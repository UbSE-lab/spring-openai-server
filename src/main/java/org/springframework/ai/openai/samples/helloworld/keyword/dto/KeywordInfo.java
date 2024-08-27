
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class KeywordInfo {
    private String keyword;

    public static KeywordInfo from(String keyword){
        return new KeywordInfo(
                keyword
        );
    }
}
