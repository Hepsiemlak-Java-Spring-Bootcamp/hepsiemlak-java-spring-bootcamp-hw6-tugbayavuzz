package emlakburada;

import emlakburada.client.BannerClient;
import emlakburada.dto.AdvertRequest;
import emlakburada.dto.response.AdvertResponse;
import emlakburada.model.Advert;
import emlakburada.model.User;
import emlakburada.model.enums.UserType;
import emlakburada.queue.QueueService;
import emlakburada.repository.AdvertRepository;
import emlakburada.repository.UserRepository;
import emlakburada.service.AdvertService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class AdvertServiceTest {

    @InjectMocks
    private AdvertService advertService;

    @Mock
    private AdvertRepository advertRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private BannerClient bannerClient;

    @Mock
    private QueueService queueService;

    @Test()
    @DisplayName("when user not found throw exception. " + "method name can be: should_throw_exception_when_user_not_found")
    void saveAdvertWithoutUserTest() {

        assertThrows(Exception.class, () -> {
            advertService.saveAdvert(prepareAdvertRequest());
        }, "İlan kaydedilemedi");
         //assertEquals("İlan kaydedilemedi", thrown.getMessage());
    }

    @Test
    void whenGetAllAdverts_thenReturnTrue() throws Exception {
        List<AdvertResponse> advertResponses = advertService.getAllAdverts();
        assertTrue(advertResponses.isEmpty());
    }

    @Test
    void saveAdvertWithUserTest() throws Exception {
        AdvertRequest request = prepareAdvertRequest();
        Optional<User> user = Optional.of(prepareUser());

        Mockito
                .when(userRepository.findById(request.getUserId()))
                .thenReturn(user);

        Mockito
                .when(advertRepository.save(any()))
                .thenReturn(prepareAdvert("başlık"));

        assertDoesNotThrow(() -> {
            AdvertResponse response = advertService.saveAdvert(request);
            assertEquals("başlık", response.getBaslik());

        });

    }

    @Test
    void saveAdvertWithUserTest1() throws Exception {
        AdvertRequest request = prepareAdvertRequest();

        Optional<User> user = Optional.of(prepareUser());
        Mockito
                .when(userRepository.findById(request.getUserId()))
                .thenReturn(user);

        Mockito
                .when(advertRepository.save(any()))
                .thenReturn(prepareAdvert("başlık"));

        AdvertResponse response = advertService.saveAdvert(request);
        assertEquals("başlık", response.getBaslik());
    }

    @Test
    void getAllAdvertsTest() {

        Mockito
                .when(advertRepository.findAll())
                .thenReturn(prepareAdvertList());

        List<AdvertResponse> responseList = advertService.getAllAdverts();

        assertNotEquals(1, responseList.size());

        assertThat(responseList.size()).isNotZero();

        for (AdvertResponse response : responseList) {
            assertThat(response.getAdvertNo()).isEqualTo(1);

            assertEquals(new BigDecimal(12345), response.getFiyat());

        }

    }


    @Test
    void whenGetAdvertByAdvertId_thenReturnTrue() {
        Mockito
                .when(advertRepository.findById(1))
                .thenReturn(Optional.of(prepareAdvert("başlık")));

        AdvertResponse response = advertService.getAdvertByAdvertId(1);
        assertNotNull(response);
        assertEquals("başlık", response.getBaslik());
        assertNull(response.getKullanici());
    }

    @Test
    void whenUpdateAdverts_thenReturnTrue() {
        AdvertRequest advertRequest = prepareAdvertRequest();
        Mockito
                .when(advertRepository.save(any()))
                .thenReturn(prepareAdvert("başlık"));
        AdvertResponse advertResponse = advertService.updateAdvert(advertRequest);
        assertEquals("başlık1", advertResponse.getBaslik());
    }

    @Test
    void whenDeleteAdvertsById_thenReturnTrue() {
        Mockito
                .doNothing().when(advertRepository)
                .deleteById(1);
        advertService.deleteAdvert(1);
        verify(advertRepository).deleteById(1);
    }

    private List<Advert> prepareAdvertList() {
        List<Advert> adverts = new ArrayList<>();
        adverts.add(prepareAdvert("başlık1"));
        adverts.add(prepareAdvert("başlık2"));
        adverts.add(prepareAdvert("başlık3"));
        return adverts;
    }

    private Advert prepareAdvert(String baslik) {
        Advert advert = new Advert();
        advert.setId(1);
        advert.setAdvertNo(1);
        advert.setBaslik(baslik);
        advert.setFiyat(new BigDecimal(12345));
        return advert;
    }

    private User prepareUser() {
        User user = new User(UserType.CORPORATE, "tugba", "email");
        user.setId(1);
        return user;
    }

    private AdvertRequest prepareAdvertRequest() {
        AdvertRequest request = new AdvertRequest();
        request.setUserId(1);
        request.setBaslik("başlık");
        request.setSuresi(3);
        request.setFiyat(new BigDecimal(12345));
        return request;
    }
}
