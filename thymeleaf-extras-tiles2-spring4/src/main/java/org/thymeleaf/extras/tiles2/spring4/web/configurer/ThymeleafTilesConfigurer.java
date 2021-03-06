/*
 * =============================================================================
 * 
 *   Copyright (c) 2011-2014, The THYMELEAF team (http://www.thymeleaf.org)
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * 
 * =============================================================================
 */
package org.thymeleaf.extras.tiles2.spring4.web.configurer;

import org.apache.tiles.startup.TilesInitializer;
import org.springframework.util.ClassUtils;
import org.springframework.web.servlet.view.tiles2.TilesConfigurer;
import org.thymeleaf.extras.tiles2.spring4.web.startup.ThymeleafTilesInitializer;




/**
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class ThymeleafTilesConfigurer 
        extends TilesConfigurer {

    
    protected static final boolean tiles22Present = ClassUtils.isPresent(
            "org.apache.tiles.evaluator.AttributeEvaluatorFactory", TilesConfigurer.class.getClassLoader());
    
    

    public ThymeleafTilesConfigurer() {
        super();
        if (!tiles22Present) {
            throw new IllegalStateException(this.getClass().getSimpleName() + " requires Tiles version 2.2+");
        }
    }





    /**
     * <p>
     *   Use a Thymeleaf-enabled initializer.
     * </p>
     */
    @Override
    protected TilesInitializer createTilesInitializer() {
        return new ThymeleafTilesInitializer(this);
    }

    
   
}
