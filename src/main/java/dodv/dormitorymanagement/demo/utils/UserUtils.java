
    package dodv.dormitorymanagement.demo.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

    public class UserUtils {
        public static String getCurrentUserName(){
            Authentication currentUser =  SecurityContextHolder.getContext().getAuthentication();
            return currentUser.getName();
        }
    }


