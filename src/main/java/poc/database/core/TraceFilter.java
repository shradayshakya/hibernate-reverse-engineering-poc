package poc.database.core;
import io.micronaut.core.async.publisher.Publishers;
import io.micronaut.http.*;
import io.micronaut.http.annotation.Filter;
import io.micronaut.http.filter.*;
import org.reactivestreams.Publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.math.BigDecimal;

@Filter("/api/**")
public class TraceFilter implements HttpServerFilter {

    @Inject
    private GenericReadRepository genericReadRepository;

    private static final Logger LOG = LoggerFactory.getLogger(TraceFilter.class);

    @Override
    public Publisher<MutableHttpResponse<?>> doFilter(HttpRequest<?> request, ServerFilterChain chain) {
        var urlComponents = request.getUri().toString().split("/");
        var resourceClass = getEntityClass(urlComponents[2]);

        if(resourceClass != null) {
            return Publishers.map(chain.proceed(request), mutableHttpResponse -> {
                if (urlComponents.length == 4) {
                    return HttpResponse.ok().body(genericReadRepository.findById(resourceClass, new BigDecimal(urlComponents[3])));
                } else {
                    return HttpResponse.ok().body(genericReadRepository.findAll(resourceClass));
                }
            });
        }

        return chain.proceed(request);
    }

    Class getEntityClass(String entityClassName) {
        var className = entityClassName.substring(0, 1).toUpperCase() + entityClassName.substring(1);
        try {
            return Class.forName("poc.database.core.models." + className);
        } catch (ClassNotFoundException classNotFoundException) {
            System.out.println(classNotFoundException);
            return null;
        }
    }
}