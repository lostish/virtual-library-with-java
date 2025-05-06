package sh.losti.app.test;

import sh.losti.app.constants.AuthConstants;
import sh.losti.app.dao.AuthDaoImpl;
import sh.losti.app.services.AuthServices;

public class DbTest {
    //private static final AuthDaoImpl authDao = AuthDaoImpl.getInstance();
    private static final String email = "tesexample@gmail.com";
    private static final String password = "cyMAvzg^fT0kBu8bu5dPF&hZHzWNcC#!bz%EAr514NUt9MY$x6fHP*Fxy3Q#q5MT";
    private static final AuthServices authServices = AuthServices.getInstance();

    public static void main(String[] args) {
        boolean ok   = authServices.login(email, password);

        System.out.println("Login success? " + ok);
        /*
        boolean result = authDao.createUser(
                "lost",
                "lost",
                "imlostishdev@gmail.com",
                "FfK9RM$D*9Pw@tzzXG2snKfdfzmfwxYn34yB5bU62z2@Qd8Jx!^&e70#&JbncFaX"
        );
        String pr = "% Resultado de la creaciòn de usuario: " + result;
        System.out.println(pr);

        boolean isEmailValid = AuthConstants.getEmailRegex().matcher(email).matches();
        boolean isPasswordValid = AuthConstants.getPasswordRegex().matcher(password).matches();
        String pr2 = "% Resultado de la verificaciòn: [" + isEmailValid + ", " + isPasswordValid + "]";
        System.out.println(pr2);
        */
    }
}
