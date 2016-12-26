/*
 * Copyright (c) 2016, ElieTGM and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of ElieTGM or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */
package net.mm;

import java.util.logging.Level;

import net.mm.bukkit.BukkitExtension;

import org.bukkit.plugin.java.JavaPlugin;

public class MaintenanceBukkit extends JavaPlugin {

	// Let's go ahead and create a private static instance of our JavaPlugin, then initialize it in our onEnable().
	private static MaintenanceBukkit instance;
	
	/**
	 * <p> The method {@link MaintenanceBukkit#getInstance()} will provide you with all necessities, including configuration properties.
	 * <p>
	 * @return Instance of JavaPlugin
	 */
	public static MaintenanceBukkit getInstance() { return instance; }
	
	
	/**
	 * <p> This is the {@link #onEnable()} method off MaintenanceMode Bukkit's interface. Please do not touch that. Only invoke if you've
	 * <p> you've gotten the source code and added it to your server's core (developers) using {@link MaintenanceBukkit#onEnable()}.
	 */
	@Override
	public void onEnable() {
		
		// With this below line we've initialized our static extension.
		instance = this;
		
		// Let's get a BukkitExtension instance, then initiate some methods!
		BukkitExtension be = new BukkitExtension(this);
		
		// Let's initialize and find soft-depends then enable sub-extensions.
		be.init();
		
	}
	
	
	/**
	 * <p>You can use this method {@link #log(Level, String)} to log <i>Bukkit</i> information using MaintenanceMode's console.
	 * @param logLevel (Level.ENUM)
	 * @param message 
	 */
	public void log(Level logLevel, String message) {
		getLogger().log(logLevel, "[MaintenanceMode] " + message);
	}

	
}
