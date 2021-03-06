/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 *   Jan Koehnlein - Initial API and implementation
 *******************************************************************************/
package com.github.jknack.antlr4ide.ui.railroad.figures;

import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.Region;

import com.github.jknack.antlr4ide.ui.railroad.figures.layout.SequenceLayout;
import com.github.jknack.antlr4ide.ui.railroad.figures.primitives.AbstractNode;
import com.github.jknack.antlr4ide.ui.railroad.figures.primitives.NodeType;
import com.github.jknack.antlr4ide.ui.railroad.figures.primitives.PrimitiveFigureFactory;

/**
 * A segment containing a single {@link Node}.
 *
 * @author Jan Koehnlein - Initial contribution and API
 */
public class NodeSegment extends AbstractSegmentFigure {

  private String name;

  public NodeSegment(final EObject eObject, final NodeType nodeType, final String name,
      final String doc, final PrimitiveFigureFactory primitiveFactory, final Region textRegion) {
    super(eObject);
    this.name = name;
    AbstractNode node = primitiveFactory.createNode(nodeType, eObject, name, this, textRegion);
    setEntry(node);
    setExit(node);
    setToolTip(new Label(doc));
  }

  public String getName() {
    return name;
  }

  @Override
  protected LayoutManager createLayoutManager() {
    return new SequenceLayout();
  }

}
