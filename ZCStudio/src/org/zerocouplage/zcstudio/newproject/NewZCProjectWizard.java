package org.zerocouplage.zcstudio.newproject;

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;

/**
 * Wizard class
 */
public class NewZCProjectWizard extends Wizard implements INewWizard {
	public static final String copyright = "(c) Copyright 2015 ZCStudio";
	// wizard pages
	NewZCProjectMainPage newZCProjectPage;
	NewZCProjectSettingsPage settingsPage;

	// the model

	NewZCProjectModel model;

	// workbench selection when the wizard was started
	protected IStructuredSelection selection;

	// flag indicated whether the wizard can be completed or not

	protected boolean creationCompleted = false;

	// the workbench instance
	protected IWorkbench workbench;

	/**
	 * Constructor for NewZCProjectMainWizard.
	 */
	public NewZCProjectWizard() {
		super();
		model = new NewZCProjectModel();
	}

	public void addPages() {
		newZCProjectPage = new NewZCProjectMainPage(workbench, selection);
		addPage(newZCProjectPage);
		settingsPage = new NewZCProjectSettingsPage("");
		addPage(settingsPage);

	}

	/**
	 * @see IWorkbenchWizard#init(IWorkbench, IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;

	}

	public boolean canFinish() {
		// cannot complete the wizard from the first page
		if (this.getContainer().getCurrentPage() == newZCProjectPage)
			return false;
		if (settingsPage.isPageComplete())
			return true;
		return false;
	}

	// Creation finished
	public boolean performFinish() {

		try {

			model.creatProject();
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;

	}
}
