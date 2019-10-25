package fips140ext.internal;

import org.bouncycastle.jcajce.provider.BouncyCastleFipsProvider;
import org.mule.runtime.api.lifecycle.Initialisable;
import org.mule.runtime.extension.api.annotation.Operations;
import org.mule.runtime.extension.api.annotation.connectivity.ConnectionProviders;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.Security;

/**
 * This class represents an extension configuration, values set in this class are commonly used across multiple
 * operations since they represent something core from the extension.
 */
@Operations(Fips140extOperations.class)
@ConnectionProviders(Fips140extConnectionProvider.class)
public class Fips140extConfiguration implements Initialisable {

  private static final Logger LOGGER = LoggerFactory.getLogger(Fips140extConfiguration.class);

  @Parameter
  private String configId;

  public String getConfigId(){
    return configId;
  }

  public void initialise()
  {
    LOGGER.info("Initializing FIPS-140 support...");

    BouncyCastleFipsProvider bcProvider = new BouncyCastleFipsProvider();
    int sequence = Security.addProvider(bcProvider);
    LOGGER.info("FIPS lib JCE sequence = " + sequence);
  }
}
