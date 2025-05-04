package sh.losti.app.facade;

import sh.losti.app.interfaces.facade.IAuthFacade;
import sh.losti.app.interfaces.services.IAuthServices;
import sh.losti.app.services.AuthServices;
import sh.losti.app.utils.OperationResult;

public class AuthFacade implements IAuthFacade {
    private final IAuthServices authServices = AuthServices.getInstance();
    private static AuthFacade instance;

    private AuthFacade() {}

    public static synchronized AuthFacade getInstance() {
        if (instance == null) {
            instance = new AuthFacade();
        }
        return instance;
    }

    @Override
    public OperationResult<Void> resetPassword(String email, String password) {
        try {
            boolean isValidE =  authServices.isValidEmail(email);            // lanza ValidationException
            boolean isValidP =  authServices.isValidEmail(password);            // lanza ValidationException

            if (!isValidE && !isValidP) throw new Exception("NOT VALID ENTRIES");

            String currentPassword = authServices.getHashedPassword(email);

            boolean equalsPwd = authServices.checkPassword(password, currentPassword);

            if (equalsPwd) throw new Exception("New password is equal to current password");

            String hashPassword = authServices.hashPassword(password);
            authServices.changePassword(email, hashPassword);
            return OperationResult.ok(null);
        }/*
        catch (ValidationException ve) {
            return OperationResult.fail(ErrorCodes.INVALID_EMAIL, ve.getMessage());
        }
        catch (NotFoundException ne) {
            return OperationResult.fail(ErrorCodes.USER_NOT_FOUND, ne.getMessage());
        }
        catch (ServiceException se) {
            // cualquier otro error de negocio
            return OperationResult.fail(ErrorCodes.DATABASE_ERROR,
                    "Ocurrió un error interno, inténtalo más tarde.");
        }*/ catch (Exception e) {
            throw new RuntimeException(e);
        }
    };

}
