package controller;

import model.Login;
import view.LoginView;

public class LoginControllerSwing {
private LoginView view = new LoginView();
private Login model = new Login();

LoginControllerSwing(LoginView view,Login model)
{
	this.view = view;
	this.model = model;
}

}
