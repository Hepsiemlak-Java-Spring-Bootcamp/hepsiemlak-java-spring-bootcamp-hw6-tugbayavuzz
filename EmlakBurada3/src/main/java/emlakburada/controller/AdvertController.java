package emlakburada.controller;

import emlakburada.dto.AdvertRequest;
import emlakburada.dto.response.AdvertResponse;
import emlakburada.service.AdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdvertController {

    @Autowired
    private AdvertService advertService;

    @GetMapping(value = "/adverts")
    public ResponseEntity<List<AdvertResponse>> getAllAdvert() {
        return new ResponseEntity<>(advertService.getAllAdverts(), HttpStatus.OK);
    }

    @PostMapping(value = "/adverts")
    public ResponseEntity<AdvertResponse> createAdvert(@RequestBody AdvertRequest request) {
        return new ResponseEntity<>(advertService.saveAdvert(request), HttpStatus.CREATED);
    }

    @GetMapping(value = "/adverts/{advertNo}")
    public ResponseEntity<AdvertResponse> getAdvertByAdvertId(@PathVariable(required = false) int advertNo) {
        return new ResponseEntity<>(advertService.getAdvertByAdvertId(advertNo), HttpStatus.OK);
    }

    @DeleteMapping(value = "/adverts/{id}")
    public ResponseEntity<AdvertResponse> deleteAdvert(@PathVariable(value = "id") int id) {
        advertService.deleteAdvert(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/adverts/{advertNo}")
    public ResponseEntity<AdvertResponse> updateAdvert(@RequestBody AdvertRequest request) {
        return new ResponseEntity<>(advertService.updateAdvert(request), HttpStatus.OK);
    }


}
