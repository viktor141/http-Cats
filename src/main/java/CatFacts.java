import com.fasterxml.jackson.annotation.JsonProperty;

public class CatFacts {
    private String id;
    private String text;
    private String type;
    private String user;
    private String upVotes;

    CatFacts(@JsonProperty("id") String id,
             @JsonProperty("text") String text,
             @JsonProperty("type") String type,
             @JsonProperty("user") String user,
             @JsonProperty("upvotes") String upVotes) {
        this.id = id;
        this.text = text;
        this.type = type;
        this.user = user;
        this.upVotes = upVotes;
    }


    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getType() {
        return type;
    }

    public String getUser() {
        return user;
    }

    public String getUpVotes() {
        return upVotes;
    }

    @Override
    public String toString() {
        return "Fact" +
                "\n id=" + id +
                "\n text=" + text +
                "\n type=" + type +
                "\n user=" + user +
                "\n upvotes=" + upVotes;
    }

    //{
    //    "id": "5b4910ae0508220014ccfe90",
    //    "text": "Кошки могут слышать ультразвук и коммуницировать с дельфинами.",
    //    "type": "cat",
    //    "user": "Alex Petrov",
    //    "upvotes": 12
    //  },
}
