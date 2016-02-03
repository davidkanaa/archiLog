package services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by davidkanaa on 16-01-29.
 */
public class ServiceRegister{

    private List<ServiceConsumer> serviceConsumers;
    private static ServiceRegister instance_;

    private ServiceRegister(){
        serviceConsumers = new ArrayList<ServiceConsumer>();
    }

    public static ServiceRegister getInstance_(){

        if (instance_ == null){
            instance_ = new ServiceRegister();
        }

        return instance_;
    }

    public List<ServiceConsumer> getServiceConsumers() {
        return serviceConsumers;
    }

    public  void loadService(ServiceConsumer s){
        serviceConsumers.add(s);
    }
}
