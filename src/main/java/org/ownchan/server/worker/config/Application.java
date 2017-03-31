/*******************************************************************************
 * @author Stefan Gündhör <stefan@guendhoer.com>
 *
 * @copyright Copyright (c) 2017, Stefan Gündhör <stefan@guendhoer.com>
 * @license AGPL-3.0
 *
 * This code is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License, version 3,
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License, version 3,
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 *******************************************************************************/
package org.ownchan.server.worker.config;

import org.ownchan.server.joint.init.InitHelper;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@EnableConfigurationProperties
@PropertySources(value = {
    @PropertySource(value = { "classpath:/config/mode/${appMode:debug}/config.properties" }),
    @PropertySource(value = { "file:${confDir}/config.properties" }),
    @PropertySource(value = { "classpath:/bootstrap.properties" }),
})
@SpringBootApplication(scanBasePackageClasses = {
    org.ownchan.server.worker.ScanBaseMarker.class,
    org.ownchan.server.joint.async.ScanBaseMarker.class,
    org.ownchan.server.joint.cache.ScanBaseMarker.class,
    org.ownchan.server.joint.thymeleaf.ScanBaseMarker.class,
})
public class Application {

  public static void main(String[] args) throws Exception {
    InitHelper.checkRequiredOwnchanServerSystemProperties();
    /*
     * ownchan-server-worker currently does not need to be a web application,
     * regardless of what maven dependencies might indicate.
     */
    new SpringApplicationBuilder(Application.class).web(false).run(args);
  }

  @Bean
  public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
    return new PropertySourcesPlaceholderConfigurer();
  }

}
