/*******************************************************************************
 * Copyright (c) 2013 Oracle and/or its affiliates. All rights reserved.
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0 
 * which accompanies this distribution. 
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at 
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *     Oracle - initial API and implementation
 ******************************************************************************/  
package org.eclipse.persistence.internal.jpa.metadata.converters;

import org.eclipse.persistence.mappings.DatabaseMapping;
import org.eclipse.persistence.mappings.converters.SerializedObjectConverter;

import org.eclipse.persistence.internal.jpa.metadata.accessors.MetadataAccessor;
import org.eclipse.persistence.internal.jpa.metadata.accessors.mappings.MappingAccessor;
import org.eclipse.persistence.internal.jpa.metadata.accessors.objects.MetadataAnnotation;
import org.eclipse.persistence.internal.jpa.metadata.accessors.objects.MetadataClass;

/**
 * INTERNAL:
 * This class processes the reserve "kryo" converter specified through @Convert.
 * 
 * Key notes:
 * - any metadata mapped from XML to this class must be compared in the
 *   equals method.
 * - when loading from annotations, the constructor accepts the metadata
 *   accessor this metadata was loaded from. Used it to look up any 
 *   'companion' annotation needed for processing.
 * - methods should be preserved in alphabetical order.
 * 
 * @author James Sutherland
 * @since EclipseLink 2.6
 */
public class KryoMetadata extends MetadataConverter {
    /**
     * INTERNAL:
     * Used for defaulting case.
     */
    public KryoMetadata() {}
    
    /**
     * INTERNAL:
     * Used for defaulting.
     */
    public KryoMetadata(MetadataAccessor accessor) {
        super(null, accessor);
    }
    
    /**
     * INTERNAL:
     * Used for annotation loading.
     */
    public KryoMetadata(MetadataAnnotation converter, MetadataAccessor accessor) {
        super(converter, accessor);
    }
    
    /**
     * INTERNAL:
     */
    @Override
    public boolean equals(Object objectToCompare) {
        return super.equals(objectToCompare) && objectToCompare instanceof KryoMetadata;
    }

    /**
     * INTERNAL:
     * Every converter needs to be able to process themselves.
     */
    @Override
    public void process(DatabaseMapping mapping, MappingAccessor accessor, MetadataClass referenceClass, boolean isForMapKey) {
        SerializedObjectConverter converter = new SerializedObjectConverter(mapping, "org.eclipse.persistence.sessions.serializers.kryo.KryoSerializer");
        setConverter(mapping, converter, isForMapKey);
    }
}
