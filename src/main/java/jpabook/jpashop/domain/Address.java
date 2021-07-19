package jpabook.jpashop.domain;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

// 불변의 임베디드 타입 생성
@Embeddable
public class Address {

    // 이런 공통된 룰을 가져갈 수 있다
    @Column(length = 10)
    private String city;
    @Column(length = 20)
    private String street;
    @Column(length = 5)
    private String zipcode;

    // 값 타입의 장점은 이런 의미있는 비즈니스 메소드를 만들 수 있다
    private String fullAddress() {
        return getCity() + getStreet() + " " + getZipcode();
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getZipcode() {
        return zipcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Address address = (Address) o;
        return Objects.equals(getCity(), address.getCity()) &&
            Objects.equals(getStreet(), address.getStreet()) &&
            Objects.equals(getZipcode(), address.getZipcode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity(), getStreet(), getZipcode());
    }
}
