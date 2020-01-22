package org.openapitools.api;

import io.swagger.annotations.ApiParam;
import org.openapitools.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-01-17T12:24:45.432663+09:00[Asia/Tokyo]")

@CrossOrigin
@Controller
@RequestMapping("${openapi.bizToi.base-path:/api}")
public class BooksApiController implements BooksApi {

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public BooksApiController(NativeWebRequest request) {
        this.request = request;
    }

    static Random random = new Random();
    static LocalDateTime date = LocalDateTime.now();

    private Book getStubBook() {
        return new Book()
                .id(UUID.randomUUID().toString())
                .title("Title")
                .detail("detail")
                .pictureUrl("https://picsum.photos/200/30" + random.nextInt(9) + ".jpg")
                .linkUrl("https://picsum.photos")
                .favorite(random.nextBoolean());
    }

    private Answer getStubAnswer(String orderId, String answerType, String questionId) {
        return new Answer()
                .id(UUID.randomUUID().toString())
                .answer("Answer")
                .answerHeadId(UUID.randomUUID().toString())
                .questionId(questionId)
                .orderId(orderId)
                .answerType(answerType)
                .inserted(date.toString())
                .modified(date.plusDays(5).toString());
    }

    private AnswerHead getStubAnswerHead(String answerId) {
        return new AnswerHead()
                .id(answerId)
                .category("")
                .publishFlg(true)
                .toiId(UUID.randomUUID().toString())
                .userId(UUID.randomUUID().toString())
                .answers(this.getStubAnswerList())
                .userInfo(new BizToiUser()
                        .id(UUID.randomUUID().toString())
                        .pictureUrl("https://picsum.photos/30/30")
                        .nickname("Biztoi Nick")
                        .country("jp")
                        .email("biztoi.tool@gmail.com")
                )
                .likeInfo(new AnswerLikes()
                        .active(random.nextBoolean())
                        .sum(new BigDecimal(random.nextInt(100)))
                )
                .inserted(date.toString())
                .modified(date.plusDays(5).toString());
    }

    private List<Answer> getStubAnswerList() {
        return Arrays.asList(
                this.getStubAnswer("1", "OBJECTIVE", "00000-00000-11111"),
                this.getStubAnswer("2", "OBJECTIVE", "00000-00000-11111"),
                this.getStubAnswer("1", "GIST", "00000-00000-22222"),
                this.getStubAnswer("2", "GIST", "00000-00000-22222"),
                this.getStubAnswer("1", "GIST", "00000-00000-33333"),
                this.getStubAnswer("1", "GIST", "00000-00000-44444"),
                this.getStubAnswer("1", "ACTION_PLAN", "00000-00000-55555")
        );
    }

    @Override
    public ResponseEntity<List<Book>> books() {
        return ResponseEntity.ok(IntStream.range(0, 50).mapToObj(i -> {
            return this.getStubBook();
        }).collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<Void> booksPost(@ApiParam(value = ""  )  @Valid @RequestBody(required = false) Book book) {
        System.out.println(book.toString());
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<AnswerHead> getAnswer(@ApiParam(value = "",required=true) @PathVariable("book_id") String bookId, @ApiParam(value = "",required=true) @PathVariable("answer_id") String answerId) {
        System.out.println("BookId: " + bookId);
        System.out.println("AnswerId: " + answerId);
        return ResponseEntity.ok(this.getStubAnswerHead(answerId));
    }

    @Override
    public ResponseEntity<List<Answer>> getAnswerByQuestion(@ApiParam(value = "",required=true) @PathVariable("book_id") String bookId,@ApiParam(value = "",required=true) @PathVariable("question_id") String questionId) {
        return ResponseEntity.ok(this.getStubAnswerList().stream()
                .filter(ans -> ans.getQuestionId().equals(questionId))
                .collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<List<AnswerHead>> getAnswers(@ApiParam(value = "",required=true) @PathVariable("book_id") String bookId) {
        return ResponseEntity.ok(IntStream.range(0, 5).mapToObj(i -> {
            return this.getStubAnswerHead(UUID.randomUUID().toString());
        }).collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<AnswerHead> getAnswersMe(@ApiParam(value = "",required=true) @PathVariable("book_id") String bookId) {
        return ResponseEntity.ok(this.getStubAnswerHead(UUID.randomUUID().toString()));
    }

    @Override
    public ResponseEntity<Book> getBookId(@ApiParam(value = "",required=true) @PathVariable("book_id") String bookId) {
        return ResponseEntity.ok(this.getStubBook());
    }

    @Override
    public ResponseEntity<Question> getBookQuestion(@ApiParam(value = "",required=true) @PathVariable("book_id") String bookId,@ApiParam(value = "",required=true) @PathVariable("question_id") String questionId) {
        return ResponseEntity.ok(this.getStubQuestionMap().get(questionId));
    }

    private Question getStubQuestion(String id, String nextId, String title, String answerType, int orderId, int step, String example) {
        return new Question()
                .id(id).toiId(UUID.randomUUID().toString()).nextQuestionId(nextId)
                .title(title).answerType(answerType).example(example).required(true)
                .orderId(BigDecimal.valueOf(orderId)).step(BigDecimal.valueOf(step));
    }

    private Map<String, Question> getStubQuestionMap() {
        Map<String, Question> map = new HashMap<String, Question>() {
            {
                put("00000-00000-11111", getStubQuestion("00000-00000-11111", "00000-00000-22222", "この本を読んだ目的を設定してみましょう", "OBJECTIVE", 1, 1, "リーダーシップを身につけたい"));
                put("00000-00000-22222", getStubQuestion("00000-00000-22222", "00000-00000-33333", "目的を達成することでどのようなメリットがありますか？( 悩みの解決・収入UP etc… )", "OBJECTIVE", 2, 2, "チームをまとめる実力を身につけ、会社の幹部へ昇格する, 後輩から慕われる存在になりたい"));
                put("00000-00000-33333", getStubQuestion("00000-00000-33333", "00000-00000-44444", "この本を読んで得られた知識を書き出してみましょう", "GIST", 3, 2, "チームで共通の目標を持つ"));
                put("00000-00000-44444", getStubQuestion("00000-00000-44444", "00000-00000-55555", "「この本から得た知識」×「自らの経験・知識」から「気付き」があれば書いてみよう！", "GIST", 4, 2, "前に読んだ本と内容が似ているが、結論が違うので、自分なりに行動をして実際に確かめてみる"));
                put("00000-00000-55555", getStubQuestion("00000-00000-55555", "00000-00000-66666", "本から得た知識を使って、どのような行動ができそうか？(すぐに書けない時は5W1Hで考えてみよう！)", "ACTION_PLAN", 5, 3, "チームで話し合って共通の目標を作る"));
                put("00000-00000-66666", getStubQuestion("00000-00000-66666", null, "行動プランを「自分の環境」でのやり方として、具体的に書いてみよう！", "ACTION_PLAN", 5, 3,
                        "朝礼後にチームメンバーを集めて共通目標の有用性について説明する。\n" +
                        "3日後までに目標を考えてくるようお願いする。\n" +
                        "3日後の朝礼後に再度集まり30分間チームメンバーで目標案を検討し決定する"));
            }
        };
        return map;
    }

    @Override
    public ResponseEntity<List<Question>> getBookQuestions(@ApiParam(value = "",required=true) @PathVariable("book_id") String bookId) {
        return ResponseEntity.ok(this.getStubQuestionMap().values().stream().sorted(Comparator.comparing(Question::getId)).collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<Toi> getBookToi(@ApiParam(value = "",required=true) @PathVariable("book_id") String bookId) {
        return ResponseEntity.ok(
                new Toi()
                        .userId(UUID.randomUUID().toString())
                        .publishFlg(true)
                        .inserted("")
                        .bookId(bookId)
                        .title("行動プランを作ってみる")
                        .detail("早速回答をしてみましょう。")
                        .inserted(date.toString())
                        .modified(date.plusDays(5).toString())
        );
    }

    @Override
    public ResponseEntity<List<Answer>> postAnswer(@ApiParam(value = "",required=true) @PathVariable("book_id") String bookId,@ApiParam(value = "",required=true) @PathVariable("question_id") String questionId,@ApiParam(value = ""  )  @Valid @RequestBody(required = false) AnswerList answerList) {
        System.out.println(answerList.toString());
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<AnswerHead> postAnswerHead(@ApiParam(value = "",required=true) @PathVariable("book_id") String bookId,@ApiParam(value = ""  )  @Valid @RequestBody(required = false) AnswerHead answerHead) {
        System.out.println(answerHead.toString());
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> postQuestion(@ApiParam(value = "",required=true) @PathVariable("book_id") String bookId,@ApiParam(value = ""  )  @Valid @RequestBody(required = false) Question question) {
        System.out.println(question.toString());
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Toi> postToi(@ApiParam(value = "",required=true) @PathVariable("book_id") String bookId,@ApiParam(value = ""  )  @Valid @RequestBody(required = false) Toi toi) {
        System.out.println(toi.toString());
        return ResponseEntity.ok().build();
    }

}
