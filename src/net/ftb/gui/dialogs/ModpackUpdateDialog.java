/*
 * This file is part of FTB Launcher.
 *
 * Copyright © 2012-2013, FTB Launcher Contributors <https://github.com/Slowpoke101/FTBLaunch/>
 * FTB Launcher is licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.ftb.gui.dialogs;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import net.ftb.gui.LaunchFrame;
import net.ftb.locale.I18N;
import net.ftb.tools.ModManager;

public class ModpackUpdateDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	private JPanel panel = new JPanel();
	private JLabel messageLbl = new JLabel(I18N.getLocaleString("UPDATEMODPACK_ISAVALIBLE"));
	private JLabel updateLbl = new JLabel(I18N.getLocaleString("UPDATE_WICHUPDATE"));
	private JButton update = new JButton(I18N.getLocaleString("MAIN_YES"));
	private JButton abort = new JButton(I18N.getLocaleString("MAIN_NO"));
	private JCheckBox backup = new JCheckBox(I18N.getLocaleString("UPDATEMODPACK_BACKUP"));

	public ModpackUpdateDialog(LaunchFrame instance, boolean modal) {
		super(instance, modal);

		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/image/logo_ftb.png")));
		setTitle(I18N.getLocaleString("UPDATEMODPACK_TITLE"));
		setBounds(300, 300, 300, 140);
		setResizable(false);

		panel.setLayout(null);
		panel.setBounds(0, 0, 300, 140);
		setContentPane(panel);

		messageLbl.setBounds(0, 0, 300, 30);
		messageLbl.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(messageLbl);

		updateLbl.setBounds(0, 20, 300, 30);
		updateLbl.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(updateLbl);

		update.setBounds(65, 80, 80, 25);
		update.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ModManager.update = true;
				ModManager.backup = backup.isSelected();
				setVisible(false);
			}
		});
		panel.add(update);

		abort.setBounds(155, 80, 80, 25);
		abort.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ModManager.update = false;
				setVisible(false);
			}
		});
		panel.add(abort);

		backup.setBounds(0, 45, 300, 30);
		backup.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(backup);
	}
}
