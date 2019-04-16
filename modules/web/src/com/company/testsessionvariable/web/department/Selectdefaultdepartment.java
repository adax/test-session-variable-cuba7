package com.company.testsessionvariable.web.department;

import com.company.testsessionvariable.entity.Department;
import com.haulmont.cuba.core.global.UserSessionSource;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.OptionsGroup;
import com.haulmont.cuba.gui.components.OptionsList;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.screen.LoadDataBeforeShow;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;

import javax.inject.Inject;
import javax.management.Notification;

@UiController("testsessionvariable_Selectdefaultdepartment")
@UiDescriptor("selectDefaultDepartment.xml")
@LoadDataBeforeShow
public class Selectdefaultdepartment extends Screen {

    @Inject
    private OptionsList<Department, Department> deptList;
    @Inject
    private UserSessionSource userSessionSource;
    @Inject
    private Notifications notifications;

    public void onOkBtnClick() {
        Department dep = deptList.getValue();
        userSessionSource
                .getUserSession()
                .setAttribute("defaultDepartment", dep);
        notifications.create()
                .withCaption("Default department set to " + dep.getName())
                .withType(Notifications.NotificationType.HUMANIZED)
                .show();

        close(WINDOW_CLOSE_ACTION);

    }

    public void onCancelBtnClick() {
        close(WINDOW_CLOSE_ACTION);
    }
}