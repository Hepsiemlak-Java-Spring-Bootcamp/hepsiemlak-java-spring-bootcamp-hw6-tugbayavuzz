package emlakburada.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Advert {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	private Integer id;
	private int advertNo;
	// private RealEstate gayrimenkul;
	private String baslik;
	@OneToOne
	private User creatorUser; // hem bireysel & kurumsal
	//private String[] resimList = new String[5];
	private BigDecimal fiyat;
	private int suresi;
	//private boolean oneCikarilsinMi = false;
	//private boolean incelendiMi = false;
	//private Date olusturulmaTarihi;
	//private boolean aktifMi;

}
