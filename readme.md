## Values from property source files that are not available in the classpath are shown as available.

1. IDEA shows the values from the test `application.properties` file as available for the source class.
2. Also, it shows the values from the main module `application.properties` file as available for the classes in the library module.

## The same-named property sources overriding

Actually, if there are few same-named property source files in the classpath,
they are not merged: the most relevant one is used.

Thus, if the `src/main/resources` root contains `application.properties`file, 
and `src/test/resources` root also contains `application.properties` file,
the latter one is used by the test class:
the values from the main `application.properties` are not available.
(see the `app-module` test class `com.mytests.spring.springpropertiesfilesoverriding.main.MainApplicationTests`)

If the `src/test/resources` root contains the `application.yaml` file, 
the values both from this file and from the main `application.properties` file are available.
(see the `lib-module` test class `com.mytests.spring.springpropertiesfilesoverriding.lib.LibApplicationTests` class)


Similarly, if the `src/main/resources` root of one module contains `application.properties` file, 
and the other module that depends on this module also contains `src/main/resources/application.properties` file,
the values from the first `application.properties` file are not available for the second module: the files are not merged.
(See the `app-module` application class `com.mytests.spring.springpropertiesfilesoverriding.main.MainApplication` class.)

Bugs:

1. IDEA ignores this fact, and shows these properties as available.
2. Spring Debugger shows these files as loaded.





