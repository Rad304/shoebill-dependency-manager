/**
 * Copyright (C) 2012 MK124
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.gtaun.shoebill.dependency;

import net.gtaun.shoebill.util.config.YamlConfiguration;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.InputStream;

/**
 * 
 * 
 * @author MK124
 */
public class DependencyManagerVersion
{
	private String name;
	private String version;
	private String support;
	private int buildNumber;
	private String buildDate;
	
	
	public DependencyManagerVersion(InputStream in)
	{
		YamlConfiguration config = new YamlConfiguration();
		config.setDefault("name", "Unknown");
		config.setDefault("version", "Unknown");
		config.setDefault("support", "Unknown");
		config.setDefault("buildNumber", 0);
		config.setDefault("buildDate", "Unknown");
		
		config.read(in);

		name = config.getString("name");
		version = config.getString("version");
		support = config.getString("support");
		buildNumber = config.getInt("buildNumber");
		buildDate = config.getString("buildDate");
	}
	
	@Override
	public String toString()
	{
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getVersion()
	{
		return version;
	}
	
	public String getSupport()
	{
		return support;
	}
	
	public int getBuildNumber()
	{
		return buildNumber;
	}
	
	public String getBuildDate()
	{
		return buildDate;
	}
}
