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

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

  @Value("${spring.application.name}")
  private String applicationName;

  @Value("${confDir}")
  private String confDir;

  @Value("${logDir}")
  private String logDir;

  /*@Bean
  public Executor dummyActionAsyncExecutor() {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(7);
    executor.setMaxPoolSize(42);
    executor.setQueueCapacity(11);
    executor.setThreadNamePrefix("DummyActionAsyncExecutor-");
    executor.initialize();
    return executor;
  }*/

  public String getApplicationName() {
    return applicationName;
  }

  public String getApplicationVersion() {
    return org.ownchan.server.worker.ScanBaseMarker.class.getPackage().getImplementationVersion();
  }

  public String getConfDir() {
    return confDir;
  }

  public String getLogDir() {
    return logDir;
  }

}
