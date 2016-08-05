package org.zerocouplage.zcstudio.shortcuts;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.debug.ui.ILaunchShortcut;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISelectionService;
import org.zerocouplage.zcstudio.Activator;
import org.zerocouplage.zcstudio.desktopLauncherAction.LaunchDesktopApp;
import org.zerocouplage.zcstudio.webLauncherAction.LaunchWebApp;

/**
 * 
 * @author najlae This class is associated with the run/debug as ZCDesktop
 *         shortcut When running the project it shows a messageBox Need to be
 *         done : Associate this class with an ant script that runs/debugs
 *         mobile application The script is ready and the class which calls it
 *         too
 *         (org.zerocouplage.zcstudio.desktopLauncherAction.LaunchDesktopApp)
 */
public class zcdesktopAction implements ILaunchShortcut {

	Shell shell = new Shell();
	String[] args;

	public zcdesktopAction() {
		// TODO Auto-generated constructor stub
		System.out.println("Ok ZCDesktop");
	}

	/**
	 * @return the name of the selected project
	 */
	protected static String sampleGetSelectedProject() {
		ISelectionService ss = Activator.getDefault().getWorkbench()
				.getActiveWorkbenchWindow().getSelectionService();
		String projExpID = "org.eclipse.ui.navigator.ProjectExplorer";
		ISelection sel = ss.getSelection(projExpID);
		Object selectedObject = sel;
		if (sel instanceof IStructuredSelection) {
			selectedObject = ((IStructuredSelection) sel).getFirstElement();
		}

		if (selectedObject instanceof IAdaptable) {
			IResource res = (IResource) ((IAdaptable) selectedObject)
					.getAdapter(IResource.class);
			IProject project = res.getProject();
			return project.getName();

		} else
			return null;

	}

	/**
	 * The main action of the Class the asscociation with the ANT script is done
	 * here
	 * 
	 * @see LaunchDesktopApp.main(args)
	 * 
	 */
	@Override
	public void launch(ISelection arg0, String arg1) {
		// TODO Auto-generated method stub
		System.out.println("Ok launch");
		MessageBox dialog = new MessageBox(shell, SWT.ICON_QUESTION | SWT.OK
				| SWT.CANCEL);
		dialog.setText("ZCDesktop Running Application");
		dialog.setMessage("You choosed to run/debug ---- "
				+ sampleGetSelectedProject() + " ---- as a Desktop Application");
		dialog.open();
		LaunchDesktopApp.main(args);

	}

	@Override
	public void launch(IEditorPart arg0, String arg1) {
		// TODO Auto-generated method stub

	}

}
