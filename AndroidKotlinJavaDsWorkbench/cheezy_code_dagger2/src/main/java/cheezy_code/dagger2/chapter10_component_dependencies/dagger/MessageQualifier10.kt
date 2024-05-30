package cheezy_code.dagger2.chapter10_component_dependencies.dagger

import java.lang.annotation.Documented
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Qualifier


@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)//CLASS, RUNTIME, SOURCE
annotation class MessageQualifier10()
