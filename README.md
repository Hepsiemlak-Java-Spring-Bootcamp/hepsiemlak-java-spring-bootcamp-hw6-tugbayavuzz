# Hepsiemlak-Java-Spring-Bootcamp-HW6
### Checked vs UnChecked Exception nedir örneklerle açıklayın.(15 Puan)
   Checked Exception
   Derleme zamanında alınan (Compile Time Exceptions), programın kontrolü dışındaki hatalardır.Derleme zamanında ide tarafından      hata verilir.
   Örneğin dosya işlemlerini yaparken karşılaşırız.Erişmek istediğimiz dosya yerinde olmaması gibi.
   
  ```
   private static void checkedExceptionWithTryCatch() {
    File file = new File("not_existing_file.txt");
    try {
        FileInputStream stream = new FileInputStream(file);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
  } 
  ```
### UnChecked Exception
  Çalışma zamınında aldığımız (Run Time Exceptions) hatalardır.Biz kodu yazdığımızda bize bir hata vermez veya ide tarafından       uyarılmayız. Uygulamayı compile ettiğimiz zaman alırız.Örneğin ArrayIndexOutOfBoundsException hatası.Bir dizinin olmayan           elemanına ulaşmak istediğimizde kodu yazarken hata vermez ama calıştırdgımızdaa bize bu hatayı fırlatır.Başka bir örnek ise       NullPointerException hatası ya da bir şeyi 0'a bölmek istersek.
  ```
  private static void divideByZero() {
    int numerator = 1;
    int denominator = 0;
    int result = numerator / denominator;
}
  ```
### Rest servis versiyonu neden ve nasıl yapılır açıklayın.(20 Puan)
  İstemcilere sunulan API kullanıcı ile istemciler arasındaki bir uygulama diyelim. Uygulamaya yeni bir şey eklendiğinde veya       çıkarıldığında aslında güncellendiğinde kafamıza göre API’daki  özelliği silemez ya da değiştiremeyiz. Değişen ihtiyaçlara göre   bir özelliği değiştirmek istediğinizde yapmanız gereken şey ise eski yapıyı bozmamak ama  yapı için yeni bir sürüm çıkartmak,     yani versiyonlamak.
 - 1) URL Path Versiyonlama<br>
 URL üzerinde path variable olarak tanımlanır. 
 Bu yöntemde versiyon farklılığını URL üzerindeki /v1 ve /v2 yapılarak belirlenir.
  ```
  http://localhost:8080/api/v1/students
  http://localhost:8080/api/v2/students
  ```
 - 2) URL Parametresi ile Versiyonlama
  URL parametresi, QueryString parametresi olarak da bilinir. 
  Bu yöntemde versiyon farklılığını URL üzerindeki ?version=1 ve ?version=2 yapılarak belirlenir.
  ```
  http://localhost:8080/api/students?version=1
  http://localhost:8080/api/students?version=2
```
 - 3) Header Versiyonlama Tekniği
  Versiyonun özel bir header ile belirtilmesi şeklindedir.
  Örnek: Version: 1.0 ya da API-Version: 1.0
  
 - 4) Custom Header Kullanarak Versiyonlama
  Header kısmına kendi belirlediğimiz key değeri ile de versiyonlama yapılabilir.
  Kendi oluşturduğumuz key lerin başına X harfi koyulması tavsiye edilir.
  ```
  @RestController
@RequestMapping("/api")
public class CustomHeaderController {

    @GetMapping(value = "/students", headers = "X-API-VERSION=1")
    public ResponseEntity<List<StudentV1>> getStudentsV1() {
        return ResponseEntity.ok(Arrays.asList(new StudentV1("Yusuf"), new StudentV1("Metin")));
    }

    @GetMapping(value = "/students", headers = "X-API-VERSION=2")
    public ResponseEntity<List<StudentV2>> getStudentsV2() {
        return ResponseEntity.ok(Arrays.asList(
                new StudentV2("Yusuf", "Alnıaçık"), new StudentV2("Metin", "Alnıaçık")));
    }
}
  ```
6. Aşağıdaki kavramları açıklayın.(15 Puan)
* Devops
  Devops, yazılım geliştiriciler ve BT personeli arasındaki boşluğu kapatmayı sağlayan bir yazılım geliştirme stratejisidir.
* DevSecOps
Genel anlamda DevSecOps, DevOps çatısına güvenliğin entegre edilmesiyle elde edilebilecek bir kültür yapısıdır.İş akışı;

- Versiyon kotrol sistemi dahilinde geliştirme yapılır.
- Uygulama üzerindeki değişiklikleri bir başka kişi değişiklik gösterilen kısmın güvenlik zafiyetleri bulundurabileceğini, kod kalitesinin nasıl olacağını ve oluşabilecek bugları göz önünde bulundurarak analiz eder.
- Uygulama güvenlik konfigürasyonları dahilinde deploy edilir.
- Deploy edilen uygulama test otomasyonu ile back-end, UI, entegrasyon, ve güvenlik alanlarında test edilir.
- Uygulama testi geçme durumunda uygulama production ortamına alınır.
- Production ortamındaki uygulama çeşitli monitoring uygulamaları ve güvenlik yazılımlarıyla gözlem altında tutulur.<br>
![image](https://user-images.githubusercontent.com/45331297/158018941-71d44497-9bc6-4926-a8a1-896f1c1f2964.png)
<br>

### Dockerfile
``
Dockerfile, uygulamanın ana root dizininde herhangi bir uzantısı olmayan ve ismi birebir ‘Dockerfile’ şeklinde olan bir dosyadan ibarettir. 
İçerisinde yayınlanacak olan uygulamanın nasıl bir ortamda çalışacağına dair talimatları barındırmaktadır. 
``
### Jenkins
``
CI: Continuous Integration yöntemi için kullanılan java ile yazılmış açık kaynak kodlu bir otomasyon sunucusudur.
Belirli bir sunucu ve portta çalışır
``
### Web server
``
Internet sitelerinin yayında kalmasını sağlayan araç olarak tanımlayabiliriz. HTTP protokolünün kullanıldığı teknoloji bütününde dosyalar, ağ üzerinden aktarılır.
``
### Application server
``
Web sunucusu  bir Web tarayıcısında görüntülenmek üzere HTML göndermekle ilgilenirken, bir uygulama sunucusu, istemci uygulama programları tarafından kullanılmak üzere iş mantığına erişim sağlar. 
``
### Tomcat
``
Apache Tomcat veya Tomcat Java tabanlı web uygulamalarını yayınlamak için kullanılan web sunucusudur.Java, Java EE veya Java Teknolojileri içerisinde Java Servlet, JavaServer Pages, Java Expression Language, Java WebSocket gibi çeşitli teknolojiler yer alır.
``

### Netty
``
Netty, protokol sunucuları ve istemciler gibi ağ uygulamalarının hızlı ve kolay bir şekilde geliştirilmesini sağlayan bir NIO istemci sunucusu framework'udur. TCP ve UDP soket sunucusu gibi ağ programlamasını büyük ölçüde basitleştirir ve düzenler.
``


```
Yararlanılan kaynaklar
https://metinalniacik.medium.com/rest-api-versiyonlama-9f1c89bfbdee
https://medium.com/@ismailbaskin/rest-api-versiyonlama-teknikleri-36fc9ded5f4
https://www.baeldung.com/rest-versioning
https://www.infinitumit.com.tr/devsecops-nedir-nasil-calisir/
https://www.gencayyildiz.com/blog/dockerfile-docker-image-docker-registry-ve-docker-container-kavramlari-nelerdir/
https://www.yusufsezer.com.tr/tomcat/
https://netty.io/

```
