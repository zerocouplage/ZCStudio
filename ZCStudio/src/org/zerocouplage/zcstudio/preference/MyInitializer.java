package org.zerocouplage.zcstudio.preference;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;

import org.eclipse.jface.preference.IPreferenceStore;
import org.zerocouplage.zcstudio.Activator;

public class MyInitializer extends AbstractPreferenceInitializer {

	public static final String copyright = "(c)Copyright 2015 ZCStudio";

	public MyInitializer() {
	}

	/**
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
	 *      initialise all preferences fields
	 */
	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		store.setDefault(PreferenceConstants.ZCSDK, "C:/ProgramFiles/ZCSDK");
		store.setDefault(PreferenceConstants.ZCWeb, "C:/ProgramFiles/ZCSDK");
		store.setDefault(PreferenceConstants.ZCDesktop, "C:/ProgramFiles/ZCSDK");
		store.setDefault(PreferenceConstants.ZCMobile, "C:/ProgramFiles/ZCSDK");
		store.setDefault(PreferenceConstants.IsClientServeurMobile, false);
		store.setDefault(PreferenceConstants.IsClientServeurDesktop, false);
	}
}
