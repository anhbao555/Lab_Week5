package vn.edu.iuh.fit.lab_week_05.backend.models;

import com.neovisionaries.i18n.CountryCode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "street", length = 150)
    private String street;

    @Column(name = "city", length = 50)
    private String city;

    @Column(name = "country")
    private Short country;

    @Column(name = "number", length = 20)
    private String number;

    @Column(name = "zipcode", length = 7)
    private String zipcode;

    private static final Map<CountryCode, Short> COUNTRY_PHONE_CODE_MAP = new HashMap<>();

    static {
        COUNTRY_PHONE_CODE_MAP.put(CountryCode.VN, (short) 84);
        COUNTRY_PHONE_CODE_MAP.put(CountryCode.US, (short) 1);   // Mỹ
        COUNTRY_PHONE_CODE_MAP.put(CountryCode.CA, (short) 1);   // Canada
    }

    public Address(String number, String street, String city, String zipcode, CountryCode countryCode) {
        this.number = number;
        this.street = street;
        this.city = city;
        this.zipcode = zipcode;
        this.country = COUNTRY_PHONE_CODE_MAP.getOrDefault(countryCode, (short) 0);
    }
}