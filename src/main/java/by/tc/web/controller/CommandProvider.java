package by.tc.web.controller;

import by.tc.web.controller.impl.*;
import by.tc.web.controller.impl.account.*;
import by.tc.web.controller.impl.administrator.*;
import by.tc.web.controller.impl.order.*;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private static Map<CommandName, ControllerCommand> commands = new HashMap<>();

    static {
        commands.put(CommandName.AUTHENTICATION, new AuthenticationCommand());
        commands.put(CommandName.LOCALIZATION, new LocalizationCommand());
        commands.put(CommandName.REGISTRATION, new RegistrationCommand());
        commands.put(CommandName.LOGOUT, new LogOutCommandImpl());
        commands.put(CommandName.EDIT_ACCOUNT, new AccountEditCommandImpl());
        commands.put(CommandName.DELETE_ACCOUNT, new AccountDeleteCommandImpl());
        commands.put(CommandName.SHOW_ALL_USERS, new ShowAllUsersCommandImpl());
        commands.put(CommandName.SHOW_ALL_DRIVERS, new ShowAllDriversCommandImpl());
        commands.put(CommandName.SHOW_ALL_ORDERS, new ShowAllOrdersCommand());
        commands.put(CommandName.SHOW_ALL_ADMINS, new ShowAllAdminsCommandImpl());
        commands.put(CommandName.DRIVER_REGISTRATION, new DriverRegistrationCommandImpl());
        commands.put(CommandName.ADMIN_REGISTRATION, new AdminRegistrationCommandImpl());
        commands.put(CommandName.BLOCK_USER, new CustomerBlockingCommand());
        commands.put(CommandName.UNBLOCK_USER, new CustomerUnblockingCommand());
        commands.put(CommandName.BLOCK_DRIVER, new DriverBlockingCommand());
        commands.put(CommandName.UNBLOCK_DRIVER, new DriverUnblockingCommand());
        commands.put(CommandName.CONFIRM_DRIVER, new DriverConfirmingCommandImpl());
        commands.put(CommandName.CREATE_ORDER, new CreateOrderCommand());
        commands.put(CommandName.FIND_DRIVER, new FindDriverCommand());
        commands.put(CommandName.ACCEPT_ORDER, new AcceptingOrderCommand());
        commands.put(CommandName.ON_ROUTE_ORDER, new SetOnRouteOrderCommand());
        commands.put(CommandName.FINISH_ORDER, new FinishOrderCommand());
        commands.put(CommandName.CHOOSE_ORDER, new ProvideOrdersToDriverCommand());
        commands.put(CommandName.CHECK_STATUS, new CheckOrderStatusCommand());
        commands.put(CommandName.DELETE_ADMIN, new AdminDeletingCommnad());
        commands.put(CommandName.CHECK_ACTIVER_CUSTOMER_ORDER, new CheckActiveCustomerOrderCommand());
        commands.put(CommandName.DECLINE_ORDER, new DeclineOrderCommand());

    }


    public static ControllerCommand getCommand(String name) {
        return commands.get(CommandName.valueOf(name.toUpperCase()));
    }
}
