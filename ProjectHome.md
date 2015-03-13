The goal of this project is to provide a small Java library that will be used in web applications (.war) to access configuration parameters and filesystem folders external to the web application folder.
Storing configuration files or data files inside a web application has allways been a problem as you have to build a different version of the .war file for each environment (test, production...). For example many developers use Maven profiles for this purpose.
This way of working has always been a cause of errors while deploying and a nightmare for big architectures with clustered applications. Having to rebuild an application when changing a single configuration parameter is quite shocking!

Most webapplication containers have configuration mechanisms in order to provide a datasource or a configuration parameter using JNDI but these systems are often complicated (you need to use the server's admin console) and not available when unit testing or on the developpement environment (jetty:run for example).

The philosophy of this library is thas a .war file should be built once and able to run anywhere.

  * The webapp calls the component to get configuration files, parameters, or filesystem folders.
  * The component looks for the parameters as JDNI parameters, system user directory or by default in a file inside the webapp
  * Any parameter or configuration file is defined inside the webapp but can be overridden by addind a configuration file in the classpath, JNDI configuration parameters or a file in the system user folder
  * If the webapp needs a filesystem folder to work, the component will provide it by default in the user folder or a folder defined somewhere else in the configuration
  * You will never have to rebuild the webapp to run it on a different environment : just deploy it, it will use its defaul configuration parameters and folders. Just add some predefined configuration files if you need to change its configuration.
  * In addition the component will monitor configuration files in order to enable hot configuration changes.
  * All this should be easily used for projects that use Spring framework or not.