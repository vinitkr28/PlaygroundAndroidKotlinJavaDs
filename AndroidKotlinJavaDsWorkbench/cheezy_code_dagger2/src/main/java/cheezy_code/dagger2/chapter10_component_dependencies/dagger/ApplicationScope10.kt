package cheezy_code.dagger2.chapter10_component_dependencies.dagger

import java.lang.annotation.Documented
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Scope

@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
annotation class ApplicationScope10()
