package cheezy_code.dagger2.chapter9_application_component.dagger

import java.lang.annotation.Documented
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Scope

@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
annotation class ApplicationScope9()
