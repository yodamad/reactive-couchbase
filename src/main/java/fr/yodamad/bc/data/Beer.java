package fr.yodamad.bc.data;

import com.couchbase.client.java.repository.annotation.Field;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

@Document
// Lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Beer {

    @Id
    private String id;
    @Field
    private String name;
}
