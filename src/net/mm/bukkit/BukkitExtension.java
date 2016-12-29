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
package net.mm.bukkit;

import net.mm.MaintenanceBukkit;
import net.mm.bukkit.main.BukkitLoader;

import java.util.logging.Level;

public class BukkitExtension {

	// pLGlobal and TAPIGlobal are PERMANENT booleans used on starts for API Usage purposes.
	public static boolean pLGlobal = true;
	public static boolean TAPIGlobal = true;

	// Let's get an instance of MaintenanceBukkit then initialize it in BukkitExtension();
	MaintenanceBukkit mb;
	
	/**
	 * <p> You can use {@link #BukkitExtension(MaintenanceBukkit)} to initialize and find all soft-depends of Bukkit, aswell as enabling sub-extensions!
	 * <p>
	 * 
	 * @param mb (MaintenanceBukkit instance)
	 */
	public BukkitExtension(MaintenanceBukkit mb) {
		
		// Let's initialize our variable (mb).
		this.mb = mb;
		
	}
	
	/**
	 * This method searches for soft-depends and depends for MaintenanceMode. If not available, <b> DISABLE </b> MaintenanceMode or <b> DISABLE </b> extension.
	 */
	public void init() {

		// pL and TAPI are different from pLGlobal and TAPIGlobal. pL and TAPI are TEMPORARY booleans.
		boolean pL = true;
		boolean TAPI = true;

		// This plugin doesn't currently depend on anything, so let's start with the soft-depends.

		// -|> ProtocolLib <|- // (Check if ProtocolLib is enabled on the server, if not send a message and do the following)
		if(this.mb.getServer().getPluginManager().getPlugin("ProtocolLib") == null) {
			
			this.mb.log(Level.INFO, "ProtocolLib was not found. ProtocolLib softdepend will not be enabled.");
			pL = false;
			pLGlobal = false;

		}

		// -|> TGMAPI <|- // (Check if TGMAPI is enabled on the server, if not send a message and do the following)
		if (this.mb.getServer().getPluginManager().getPlugin("TGMAPI") == null) {

			this.mb.log(Level.INFO, "TGMAPI was not found. TGMAPI softdepend will not be enabled.");
			TAPI = false;
			TAPIGlobal = false;

		}

		// Let's check if pL and TGMAPI were found. Let's start off with checking if they are both enabled.
		if (pL == true && TAPI == true) {

			// Let's load the plugin since both soft-dependencies are enabled.
			BukkitLoader bL = new BukkitLoader(this.mb);
			bL.loadPlugin(true, true);

			// Let's false both since we found them both enabled to avoid bug-exploitment.
			pL = false;
			TAPI = false;

		}

		// Let's now check if pL is enabled only.
		if (pLGlobal == true) {

			// Let's load the plugin since only ProtocolLib is enabled as soft-dependency.
			BukkitLoader bL = new BukkitLoader(this.mb);
			bL.loadPlugin(true, false);

		}

		// Let's now check if TGMAPI is enabled only.
		if (TAPIGlobal == true) {

			// Let's load the plugin since only TGMAPI is enabled as soft-dependency.
			BukkitLoader bL = new BukkitLoader(this.mb);
			bL.loadPlugin(false, true);

		}

	}
	
	
	
}
