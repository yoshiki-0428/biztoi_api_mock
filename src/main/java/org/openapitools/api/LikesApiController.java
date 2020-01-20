package org.openapitools.api;

import org.openapitools.model.SendLikeInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.Valid;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-01-17T12:24:45.432663+09:00[Asia/Tokyo]")

@CrossOrigin
@Controller
@RequestMapping("${openapi.bizToi.base-path:/api}")
public class LikesApiController implements LikesApi {

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public LikesApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public ResponseEntity<Void> deleteLikesAnswers(@Valid SendLikeInfo sendLikeInfo) {
        System.out.print(sendLikeInfo.toString());
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> likesAnswers(@Valid SendLikeInfo sendLikeInfo) {
        System.out.print(sendLikeInfo.toString());
        return ResponseEntity.ok().build();
    }

}
