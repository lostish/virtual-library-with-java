package sh.losti.app.interfaces.facade;

import sh.losti.app.utils.OperationResult;

public interface IAuthFacade {
    OperationResult<Void> resetPassword(String email, String password);
}
