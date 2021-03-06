/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates.
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

package org.kie.workbench.common.forms.dynamic.client.rendering.formGroupDisplayers.impl.checkbox;

import javax.inject.Inject;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import org.jboss.errai.common.client.dom.DOMUtil;
import org.jboss.errai.common.client.dom.Div;
import org.jboss.errai.common.client.dom.Document;
import org.jboss.errai.common.client.dom.Label;
import org.jboss.errai.common.client.dom.Span;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.kie.workbench.common.forms.model.FieldDefinition;

@Templated
public class CheckBoxFormGroupDisplayerViewImpl extends Composite implements CheckBoxFormGroupDisplayerView {

    @Inject
    protected Document document;

    @Inject
    @DataField
    protected Label fieldLabel;

    @Inject
    @DataField
    protected Div helpBlock;

    @Inject
    protected Span labelText;

    public void render(Widget widget,
                       FieldDefinition field) {
        this.getElement().setId(generateFormGroupId(field));
        DOMUtil.appendWidgetToElement(fieldLabel,
                                      widget);
        labelText.setTextContent(field.getLabel());

        if (field.getRequired()) {
            labelText.appendChild(getRequiredElement(document));
        }
        fieldLabel.appendChild(labelText);
        helpBlock.setId(generateHelpBlockId(field));
    }
}
