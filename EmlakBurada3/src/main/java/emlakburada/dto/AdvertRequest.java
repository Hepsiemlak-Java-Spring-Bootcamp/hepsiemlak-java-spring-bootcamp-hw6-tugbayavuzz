package emlakburada.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AdvertRequest {

    private int advertNo;
    private String baslik;
    private BigDecimal fiyat;
    private int suresi;
    private boolean oneCikarilsinMi = false;
    private boolean incelendiMi = false;
    private boolean aktifMi;
    private Integer userId;

    public AdvertRequest() {
    }

    public AdvertRequest(String baslik) {
        this.baslik = baslik;
    }
}
