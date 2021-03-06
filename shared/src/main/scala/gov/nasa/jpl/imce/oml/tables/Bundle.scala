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

 
package gov.nasa.jpl.imce.oml.tables

import scala.annotation.meta.field
import scala.scalajs.js.annotation.{JSExport,JSExportTopLevel}

/**
  * @param uuid[1,1]
  * @param kind[1,1]
  * @param iri[1,1]
  */
@JSExportTopLevel("Bundle")
case class Bundle
(
  @(JSExport @field) override val uuid: taggedTypes.BundleUUID,
  @(JSExport @field) override val kind: TerminologyKind,
  @(JSExport @field) override val iri: taggedTypes.IRI
) extends TerminologyBox {
  // Ctor(uuidWithoutContainer)
  def this(
    oug: gov.nasa.jpl.imce.oml.uuid.OMLUUIDGenerator,
    kind: TerminologyKind,
    iri: taggedTypes.IRI)
  = this(
      taggedTypes.bundleUUID(oug.namespaceUUID(
        iri.toString).toString),
      kind,
      iri)

val vertexId: scala.Long = uuid.hashCode.toLong

  override val hashCode
  : scala.Int 
  = (uuid, kind, iri).##
  
  override def equals(other: scala.Any): scala.Boolean = other match {
  	case that: Bundle =>
  	  (this.uuid == that.uuid) &&
  	  (this.kind == that.kind) &&
  	  (this.iri == that.iri)
    case _ =>
      false
  }
  
}

@JSExportTopLevel("BundleHelper")
object BundleHelper {

  import io.circe.{Decoder, Encoder, HCursor, Json}
  import io.circe.parser.parse
  import scala.Predef.String

  val TABLE_JSON_FILENAME 
  : String 
  = "Bundles.json"

  implicit val decodeBundle: Decoder[Bundle]
  = Decoder.instance[Bundle] { c: HCursor =>
    
    import cats.syntax.either._
  
    for {
    	  uuid <- c.downField("uuid").as[taggedTypes.BundleUUID]
    	  kind <- c.downField("kind").as[TerminologyKind]
    	  iri <- c.downField("iri").as[taggedTypes.IRI]
    	} yield Bundle(
    	  uuid,
    	  kind,
    	  iri
    	)
  }
  
  implicit val encodeBundle: Encoder[Bundle]
  = new Encoder[Bundle] {
    override final def apply(x: Bundle): Json 
    = Json.obj(
    	  ("uuid", taggedTypes.encodeBundleUUID(x.uuid)),
    	  ("kind", TerminologyKind.encodeTerminologyKind(x.kind)),
    	  ("iri", taggedTypes.encodeIRI(x.iri))
    )
  }

  @JSExport
  def toJSON(c: Bundle)
  : String
  = encodeBundle(c).noSpaces

  @JSExport
  def fromJSON(c: String)
  : Bundle
  = parse(c) match {
  	case scala.Right(json) =>
  	  decodeBundle(json.hcursor) match {
  	    	case scala.Right(result) =>
  	    	  result
  	    	case scala.Left(failure) =>
  	    	  throw failure
  	  }
    case scala.Left(failure) =>
  	  throw failure
  }

}
