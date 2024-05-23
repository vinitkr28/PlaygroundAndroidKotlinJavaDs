package cheezy_code.dagger2.chapter8_singleton

import java.lang.annotation.Documented
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Qualifier


@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)//CLASS, RUNTIME, SOURCE
annotation class MessageQualifier8()
