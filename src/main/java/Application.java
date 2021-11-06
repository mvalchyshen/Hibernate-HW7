import ua.goit.projectmanager.controller.ControllerImpl;
import ua.goit.projectmanager.model.Company;
import ua.goit.projectmanager.model.Project;
import ua.goit.projectmanager.service.BaseService;
import ua.goit.projectmanager.service.ServiceFactory;
import ua.goit.projectmanager.util.ScriptExecutor;
import ua.goit.projectmanager.view.ViewImpl;

import java.util.HashSet;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        ScriptExecutor.start();
        new ControllerImpl(new ViewImpl()).run();
    }

}
