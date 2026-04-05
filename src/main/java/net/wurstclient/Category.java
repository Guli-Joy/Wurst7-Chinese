/*
 * Copyright (c) 2014-2025 Wurst-Imperium and contributors.
 *
 * This source code is subject to the terms of the GNU General Public
 * License, version 3. If a copy of the GPL was not distributed with this
 * file, You can obtain one at: https://www.gnu.org/licenses/gpl-3.0.txt
 */
package net.wurstclient;

public enum Category
{
	BLOCKS("Blocks", "方块"),
	MOVEMENT("Movement", "移动"),
	COMBAT("Combat", "战斗"),
	RENDER("Render", "渲染"),
	CHAT("Chat", "聊天"),
	FUN("Fun", "娱乐"),
	ITEMS("Items", "物品"),
	OTHER("Other", "其他");
	
	private final String name;
	private final String displayName;
	
	private Category(String name, String displayName)
	{
		this.name = name;
		this.displayName = displayName;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getDisplayName()
	{
		return displayName;
	}
}
