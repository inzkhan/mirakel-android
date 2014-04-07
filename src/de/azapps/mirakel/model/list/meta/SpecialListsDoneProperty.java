/*******************************************************************************
 * Mirakel is an Android App for managing your ToDo-Lists
 * 
 * Copyright (c) 2013-2014 Anatolij Zelenin, Georg Semmler.
 * 
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     any later version.
 * 
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 * 
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package de.azapps.mirakel.model.list.meta;

import android.content.Context;
import de.azapps.mirakel.model.R;
import de.azapps.mirakel.model.task.Task;

public class SpecialListsDoneProperty extends SpecialListsBaseProperty {
	private boolean done;

	public SpecialListsDoneProperty(final boolean done) {
		this.done = done;
	}

	@Override
	public String getWhereQuery() {
		return "done=" + (this.done ? "1" : "0");
	}

	public boolean getDone() {
		return this.done;
	}

	public void setDone(final boolean done) {
		this.done = done;
	}

	@Override
	public String serialize() {
		String ret = "\"" + Task.DONE + "\":{";
		ret += "\"done\":" + (this.done ? "true" : "false");
		return ret + "}";
	}

	@Override
	public String getSummary(final Context mContext) {
		return this.done ? mContext.getString(R.string.done) : mContext
				.getString(R.string.undone);
	}
}
