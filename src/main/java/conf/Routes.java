/**
 * Copyright (C) 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package conf;


import ninja.AssetsController;
import ninja.Router;
import ninja.application.ApplicationRoutes;
import controllers.ApplicationController;

public class Routes implements ApplicationRoutes {

    @Override
    public void init(Router router) {  
        
        router.GET().route("/").with(ApplicationController.class, "index");

        // US Version
        router.GET().route("/AcesUp").with(ApplicationController.class, "acesUp");
        router.GET().route("/usGame").with(ApplicationController.class, "gameGetUS");
        router.POST().route("/dealGame").with(ApplicationController.class, "dealPost");
        router.POST().route("/moveCard/{columnFrom}/{columnTo}").with(ApplicationController.class, "moveCard");
        router.POST().route("/removeCard/{column}").with(ApplicationController.class, "removeCard");

        // SP Version
        router.GET().route("/AcesUpSP").with(ApplicationController.class, "acesUpSP");
        router.GET().route("/spGame").with(ApplicationController.class, "gameGetSP");
        router.POST().route("/dealGameSP").with(ApplicationController.class, "dealPostSP");
        router.POST().route("/moveCardSP/{columnFrom}/{columnTo}").with(ApplicationController.class, "moveCardSP");
        router.POST().route("/removeCard/{column}").with(ApplicationController.class, "removeCard");

        ///////////////////////////////////////////////////////////////////////
        // Assets (pictures / javascript)
        ///////////////////////////////////////////////////////////////////////    
        router.GET().route("/assets/webjars/{fileName: .*}").with(AssetsController.class, "serveWebJars");
        router.GET().route("/assets/{fileName: .*}").with(AssetsController.class, "serveStatic");
        
        ///////////////////////////////////////////////////////////////////////
        // Index / Catchall shows index page
        ///////////////////////////////////////////////////////////////////////
//        router.GET().route("/.*").with(ApplicationController.class, "index");
    }

}
