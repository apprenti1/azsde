package org.ToutDouxList;

import lombok.*;

import java.time.LocalDate;
import java.time.Period;

@RequiredArgsConstructor
@Getter
@Setter
public class User {
    @NonNull
    private String nom;
    @NonNull
    private String prenom;
    @NonNull
    private String email;
    @NonNull
    private String pwd;
    @NonNull
    private LocalDate dateNaissance;


    private ToutDouxList toutDouxList = null;

    public boolean isValid() {
        return email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
                && pwd.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,40}$")
                && !nom.isBlank()
                && !prenom.isBlank()
                && calculateAgeFromBirthDate() >= 13;
    }

    public int calculateAgeFromBirthDate() {
        return Period.between(dateNaissance, LocalDate.now()).getYears();
    }


    public void setToutDouxList(ToutDouxList toutDouxList) {
        this.toutDouxList = toutDouxList;
        this.toutDouxList.setUser(this);
    }
}

