package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
public class UserEntity {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id; // 유저에게 고유하게 부여되는 id.

    @Column(nullable = false)
    private String username; // 유저의 이름

    @Column(nullable = false)
    private String email; // 유저의 email, 아이디와 같은 기능을 한다.

    @Column(nullable = false)
    private String password; //null 가능한 이유 Auth로 페이스북이나 트위터같은 제3의 어플리케이션을 통해 로그인 할 수 있게 하기 위함이다.
}
