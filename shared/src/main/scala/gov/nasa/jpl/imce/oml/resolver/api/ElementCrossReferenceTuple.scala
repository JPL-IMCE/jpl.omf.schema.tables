/*
 * Copyright 2016 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
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
 * License Terms
 */

package gov.nasa.jpl.imce.oml.resolver.api

/*
 * An OML ElementCrossReferenceTuple is an abstraction for a kind of OML Element
 * categorized as a OML CrossReferencableKind and OML ExtrinsicIdentityKind
 * where the extrinsic identity criteria is precisely
 * a tuple of at least 2 cross references to other OML IdentityKind(s)
 * and nothing else.
 */
trait ElementCrossReferenceTuple
  extends ExtrinsicIdentityKind
  with CrossReferencableKind
  with LogicalElement
{
  override val uuid: taggedTypes.ElementCrossReferenceTupleUUID
}
