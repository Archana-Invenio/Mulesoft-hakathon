package com.mule.alexa;

import org.mule.runtime.extension.api.annotation.Configurations;
import org.mule.runtime.extension.api.annotation.Extension;
import org.mule.runtime.extension.api.annotation.dsl.xml.Xml;




@Xml(prefix="alexa")
@Extension(name="Alexa")
@Configurations(AlexaMuleConfiguration.class)
public class AlexaMuleExtension {

}
