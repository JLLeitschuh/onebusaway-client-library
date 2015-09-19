/*
 * Copyright (C) 2010 Paul Watts (paulcwatts@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.onebusaway.io.client.request;

import org.onebusaway.io.client.elements.ObaReferences;
import org.onebusaway.io.client.elements.ObaReferencesElement;
import org.onebusaway.io.client.elements.ObaRoute;
import org.onebusaway.io.client.elements.ObaStop;
import org.onebusaway.io.client.elements.ObaStopElement;
import org.onebusaway.location.Location;

import java.util.List;

/**
 * Response object for ObaStopRequest requests.
 *
 * @author Paul Watts (paulcwatts@gmail.com)
 */
public final class ObaStopResponse extends ObaResponseWithRefs implements ObaStop {

    private static final class Data {

        private static final Data EMPTY_OBJECT = new Data();

        private final ObaReferencesElement references = ObaReferencesElement.EMPTY_OBJECT;

        private final ObaStopElement entry = ObaStopElement.EMPTY_OBJECT;
    }

    private final Data data;

    private ObaStopResponse() {
        data = Data.EMPTY_OBJECT;
    }

    @Override
    public String getId() {
        return data.entry.getId();
    }

    @Override
    public String getStopCode() {
        return data.entry.getStopCode();
    }

    @Override
    public String getName() {
        return data.entry.getName();
    }

    @Override
    public Location getLocation() {
        return data.entry.getLocation();
    }

    @Override
    public double getLatitude() {
        return data.entry.getLatitude();
    }

    @Override
    public double getLongitude() {
        return data.entry.getLatitude();
    }

    @Override
    public String getDirection() {
        return data.entry.getDirection();
    }

    @Override
    public int getLocationType() {
        return data.entry.getLocationType();
    }

    @Override
    public String[] getRouteIds() {
        return data.entry.getRouteIds();
    }

    /**
     * Returns the list of dereferenced routes.
     */
    public List<ObaRoute> getRoutes() {
        return data.references.getRoutes(data.entry.getRouteIds());
    }

    @Override
    protected ObaReferences getRefs() {
        return data.references;
    }
}
