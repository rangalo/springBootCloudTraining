package net.boddin.clouddemo.auditing;

import net.boddin.clouddemo.entity.User;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public String getCurrentAuditor() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth == null){
            return "default";
        };
        User o = (User) auth.getPrincipal();
        return o.getUsername();
    }
}
